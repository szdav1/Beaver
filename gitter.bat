@REM Gitter Version 1.5.0
@echo off
cls
echo Gitter V.1.5.0
SET mode=%1

if not defined mode echo Mode not specified. Use --up or --dwn.

if %mode%==--up (
    echo Pushing...
    git add .
    git commit -m %2
    git push origin %3
)