@echo off
set ttc1=%1
set ttc2=%2
set dest1=%3
set dest2=%4
copy %ttc1% %dest1%
xcopy %ttc2% %dest2% /E /y