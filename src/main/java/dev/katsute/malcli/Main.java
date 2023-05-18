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

import java.util.logging.Logger;

import dev.katsute.malcli.cli.CLI;
import dev.katsute.malcli.cli.Command;
import dev.katsute.malcli.cli.CLIException;

final class Main {

    private static final Logger logger = Logger.getGlobal();

    private static final Command[] commands = {};

    public static void main(final String[] args) {
        try{
            // logging

            // exec
            final CLI cli = CLI.parse(args);
            final String cmd = cli.getCommand();
            Command match;
            for(final Command command : commands){
                // check starts with

                // match most specific command
            }
        }catch(final CLIException e){
            // log err
        }catch(final Throwable e){
            // crash
        }
    }

}