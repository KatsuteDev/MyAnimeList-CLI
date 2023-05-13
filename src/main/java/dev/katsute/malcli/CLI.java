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

package dev.katsute.malcli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class CLI {

    private final Map<String,List<String>> map;

    private CLI(final Map<String,List<String>> map){
        this.map = map;
    }

    static CLI parse(final String[] args){
        final Map<String,List<String>> map = new HashMap<>();
        String key = null;
        List<String> values = null;
        boolean end_of_opts = false;
        for(final String arg : args){
            if(end_of_opts)
                values.add(arg);
            else if(arg.equals("--")){
                end_of_opts = true;
            }else if(arg.startsWith("-")){
                if(key != null){
                    map.put(key, values);
                    key = arg;
                    values = new ArrayList<>();
                }else
                    key = arg;
            }else
                values.add(arg);
        }
        if(key != null)
            map.put(key, values);
        return new CLI(map);
    }

    public final boolean containsFlag(final String... flags){
        for(final String arg : flags)
            if(map.containsKey(arg))
                return true;
        return false;
    }

    public final boolean isFlagOnly(final String flag){
        return map.get(flag).isEmpty();
    }

    public final boolean containsFlagArgs(final String flag){
        return map.get(flag).size() == 1;
    }

    public final boolean containsFlagArgs(final String flag, final int args){
        return map.get(flag).size() == args;
    }

}