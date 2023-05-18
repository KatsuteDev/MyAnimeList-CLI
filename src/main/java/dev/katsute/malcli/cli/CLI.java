/*
 * Copyright (C) 2023 Katsute <https://github.com/Katsute>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package dev.katsute.malcli.cli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CLI {

    public abstract String getCommand();

    public abstract <T> T getOption(final Option<T> option);

    public abstract boolean hasOption(final Option<?> option);

    public static CLI parse(final String[] args){
        // separate by flag delim -
        final List<List<String>> parts = new ArrayList<>();

        List<String> li = new ArrayList<>();
        for(final String arg : args){
            if(arg.startsWith("-")){
                parts.add(li);
                li = new ArrayList<>();
            }
            li.add(arg);
        }
        parts.add(li);

        // command is first except if flag
        final String command = parts.size() > 0 && parts.get(0).size() > 0 && !parts.get(0).get(0).startsWith("-")
                               ? parts.get(0).get(0)
                               : null;

        if(command != null)
            parts.remove(0);

        // flags
        final List<String> argSet = command != null
                                    ? parts.stream().map(l -> l.get(0)).toList()
                                    : Collections.emptyList();

        return new CLI(){

            @Override
            public final String getCommand(){
                return command;
            }

            @Override
            public final <T> T getOption(final Option<T> option){
                // find option
                final String flag = option.getFlag() != null ? '-' + option.getFlag() : null;
                final String longFlag = option.getLongFlag() != null ? "--" + option.getLongFlag() : null;

                if(hasOption(option)){
                    T arg = null;
                    final int expect = option.hasArg() ? 2 : 1;
                    for(final List<String> args : parts){ // check all arg sets
                        final int size = args.size();
                        if(size > 0 && args.get(0).equals(flag) || args.get(0).equals(longFlag)){ // matching flag
                            if(size != expect) // incorrect amount of args
                                throw new CLIException(String.format("%s flag expected %d arguments but got %d", args.get(0), expect, size));
                            else if(size == 1) // flag only
                                return null;
                            else if(arg == null) // flag + arg
                                arg = option.cast(args.get(1));
                            else // duplicate flag
                                throw new CLIException(String.format("%s flag was already added", args.get(0)));
                        }
                    }
                    return arg;
                }else
                    return null;
            }

            @Override
            public final boolean hasOption(final Option<?> option){
                return
                    (option.getFlag() != null && argSet.contains('-' + option.getFlag())) ||
                    (option.getLongFlag() != null && argSet.contains("--" + option.getLongFlag()));
            }

            @Override
            public final String toString() {
                return "CLI{" +
                       "command='" + command + "', " +
                       "args=" + parts +
                       "}";
            }

        };
    }

}