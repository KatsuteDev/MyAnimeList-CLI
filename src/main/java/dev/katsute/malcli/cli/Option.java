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

import java.util.function.Function;

public abstract class Option<T> {

    public abstract String getFlag();

    public abstract String getLongFlag();

    public abstract String getDescription();

    public abstract boolean hasArg();

    public abstract T getDefault();

    public abstract T cast(final String string); // verify arg here

    public static class Builder<T> {

        private String flag, longFlag, desc;
        private Boolean hasArg;
        private T def;

        private Function<String,T> cast;

        public Builder(final String flag){
            this.flag = flag;
        }

        public final Builder<T> setFlag(final String flag){
            this.flag = flag;
            return this;
        }

        public final Builder<T> setLongFlag(final String longFlag){
            this.longFlag = longFlag;
            return this;
        }

        public final Builder<T> setDesc(final String desc){
            this.desc = desc;
            return this;
        }

        public final Builder<T> hasArg(){
            this.hasArg = true;
            return this;
        }

        public final Builder<T> noArgs(){
            this.hasArg = false;
            return this;
        }

        public final Builder<T> setDefault(final T def){
            this.def = def;
            return this;
        }

        public final Builder<T> setCast(final Function<String,T> cast){
            this.cast = cast;
            return this;
        }

        public final Option<T> build(){
            return new Option<T>(){

                @Override
                public final String getFlag(){
                    return flag;
                }

                @Override
                public final String getLongFlag(){
                    return longFlag;
                }

                @Override
                public final String getDescription(){
                    return desc;
                }

                @Override
                public final boolean hasArg(){
                    return hasArg;
                }

                @Override
                public final T getDefault(){
                    return def;
                }

                @Override
                public final T cast(final String string){
                    return cast.apply(string);
                }

                @Override
                public final String toString() {
                    return "Option{" +
                           "flag='" + flag + "', " +
                           "longFlag='" + longFlag + "', " +
                           "description='" + desc + "', " +
                           "hasArg=" + hasArg + ", " +
                           "def='" + def + "'" +
                           + '}';
                }

            };
        }

    }

}