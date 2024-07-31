@echo off
set tts1=%1
set tts2=%2
set dest1=%3
set dest2=%4
copy %tts1% %dest1%
xcopy %tts2% %dest2% /E /y
