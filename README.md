
Android N Parceler AlarmManager/Broadcast Issue reproduction.
===================================
THIS IS A FORK OF https://github.com/googlesamples/android-RepeatingAlarm

Open issue on the tracker:
https://code.google.com/p/android/issues/detail?id=216581&thanks=216581&ts=1468962325

S/O post:
http://stackoverflow.com/questions/38466080/dp5-7-0-does-adding-extras-to-a-pending-intent-fail

Running the code in this project will enable the developer to analyze the logs and see that a Parceled extra combined with a long value in an intent within PendingIntent will not be correctly unmarshalled upon receit in the Broadcast Receiver (AlarmManagerUtil.java) only in Android N (Developer Preview)

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
