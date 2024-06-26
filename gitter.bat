@REM Gitter Version 1.5.0
@echo off
cls
echo Gitter V.2.0.1
echo ==============
SET mode=%1

if not defined mode goto mnsel

if %mode%==--up goto pushl

if %mode%==--dwn goto pulll

if %mode%==--dwn-ovr goto pullhardl

:pushl
SET msg=%2
SET branch=%3

if not defined msg goto msgndel

if not defined branch goto branchndel

echo >> Pushing to %branch%

git add .
git commit -m %msg%
git push origin %branch%
goto exitl

:pulll
SET branch=%2

if not defined branch goto branchndel

echo << Pulling from %branch%...

git add .
git commit -m "Committing before pushing."
git pull origin %branch%
goto exitl

:pullhardl
SET branch=%2

if not defined branch goto branchndel

echo << Overriding from %branch%...

git fetch --all
git reset --hard origin/%branch%
goto exitl

:msgndel
echo Commit message not specified.
goto exitl

:branchndel
echo Branch not specified.
goto exitl

:mnsel
echo Mode not specified. Use --up, --dwn or --dwn-ovr.
goto exitl

:exitl