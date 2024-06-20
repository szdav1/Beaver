@REM Gitter Version 1.0.0
@echo off
echo "Gitter V.1.0.0"
cls
SET mode=%1

if %mode%==--up (
    echo Pushing...
    git add .
    git commit -m %2
    git push origin %3
)

if %mode%==dwn (

)