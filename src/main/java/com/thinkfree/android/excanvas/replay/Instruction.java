/*
 * Copyright 2013 Alan Goo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thinkfree.android.excanvas.replay;

import java.util.Arrays;

/**
 * for Save/Load with minimal number of classes and members.
 * note that not optimized and subject to change
 * @author Alan Goo
 */
public class Instruction {
    public int opId;
    public Object param;

    public Instruction(int opId, Object param) {
        this.opId = opId;
        this.param = param;
    }

    @Override
    public String toString() {
        return String.format("Instruction[opid:%d] %s", opId, paramToString(param));
    }

    private static String paramToString(Object param) {
        if(param==null) return "";  // do not print
        if(param instanceof Object[]) return Arrays.deepToString((Object[]) param);
        return param.toString();
    }
}