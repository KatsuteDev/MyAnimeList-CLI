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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Command {

    private final String command, help;
    private final int args;
                  // [Option, Required]
    private final Map<Option<?>,Boolean> options;
    private final List<Option<?>> required = new ArrayList<>();

    public Command(final String command, final int args, final String help, final Map<Option<?>,Boolean> options){
        this.command = command;
        this.args = args;
        this.help = help;
        this.options = Map.copyOf(options);
        this.options.forEach((k, v) -> {
            if(v)
                required.add(k);
        });
    }

    public final String getCommand(){
        return command;
    }

    public final Map<Option<?>,Boolean> getOptions(){
        return Map.copyOf(options);
    }

    public final String help(){
        return help;
    }

    public final String execute(final CLI cli){
        final String[] args = Arrays.copyOfRange(cli.getCommand().split(" "), command.split(" ").length, cli.getCommand().split(" ").length);

        // help
        if(args.length == 0)
            return help();

        // check required flags
        for(final Option<?> required : this.required)
            if(!cli.hasOption(required))
                throw new CLIException(String.format("Missing required option %s", required.getLongFlag()));

        // check args count
        if(args.length != this.args)
            throw new CLIException(String.format("Expected %d arguments but got %d", this.args, args.length));

        // delegate
        return exec(cli, args);
    }

    // asserted that required flags and correct arg count
    // check arg type in method
    abstract String exec(final CLI cli, final String... args);

}