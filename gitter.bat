@REM Gitter Version 1.5.0
@echo off
cls
echo  Gitter V.2.0.1
echo ================
SET mode=%1

if not defined mode goto mnsel

if %mode%==--up goto pushl

if %mode%==--dwn goto pulll

if %mode%==--dwn-ovr goto pullhardl

if %mode%==? goto helpl

if %mode%==help goto helpl

:pushl
SET msg=%2
SET branch=%3

if not defined msg goto msgndel

if not defined branch goto branchndel

echo Pushing to %branch%

git add .
git commit -m %msg%
git push origin %branch%
goto exitl

:pulll
SET branch=%2

if not defined branch goto branchndel

echo Pulling from %branch%...

git add .
git commit -m "Committing before pulling."
git pull origin %branch%
goto exitl

:pullhardl
SET branch=%2

if not defined branch goto branchndel

echo Overriding from %branch%...

git fetch --all
git reset --hard origin/%branch%
goto exitl

:helpl
echo  Helper
echo ========
echo As first argument, define the mode:
echo --up: For uploading, pushing to a repository
echo --dwn: For downloading, pulling from a repository
echo --dwn-ovr: For downloading and overriding, fetching and hard resetting from a repository
echo ==========================================================================================
echo  Pushing
echo =========
echo When pushing, the second argument should be the commit message
echo The third argument in case of pushing should be the name of the branch where the push should be done
echo ====================================================================================================
echo  Pulling
echo =========
echo When pulling, the second argument should be the name of the branch from where the pull should be conducted
echo ==========================================================================================================
echo  Hard Pulling
echo ==============
echo When hard-pulling, the second argument should be the name of the branch from where the hard-pull should be conducted
echo ====================================================================================================================
echo  Examples
echo ==========
echo gitter --up "This is a commit message" branch
echo gitter --dwn branch
echo gitter --dwn-ovr branch

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