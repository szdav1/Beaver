@echo off
cls
SET v1=%1
if %v1%=="Up" (
    git add .
)