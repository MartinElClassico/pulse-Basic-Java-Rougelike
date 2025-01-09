REM bash script to compile the java files into .class binaries for users on windows machines.

@echo off
REM we do not want it to print the rest of this script to the user, thus echo off.

REM Holds source directiory to compile from and output direction to compile to.
REM %~dp0 is a bash token that expands into the scripts location.
set "SRC_DIR=%~dp0DragonTreasure\src"
set "OUT_DIR=%~dp0DragonTreasure\bin"
set MAIN_FILE=main.DragonTreasure

REM create output directory, remove old one.
if exist "%OUT_DIR%" (
    rmdir /s /q "%OUT_DIR%"
)
mkdir "%OUT_DIR%"

REM Compile all .java files recursively.
echo Compiling Java source files...
javac -d "%OUT_DIR%" -sourcepath "%SRC_DIR%" "%SRC_DIR%\main\DragonTreasure.java"
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo.
echo Compilation completed successfully.
echo Press enter if you wish to play the game, otherwise just quit this terminal.
pause >nul
echo Running the game...
REM empty lines to distinguish between game and bash script.
echo _
echo _
echo _
REM run the game.
java -cp "%OUT_DIR%" "%MAIN_FILE%"
REM empty lines to distinguish between game and bash script.
echo _
echo _
echo _
REM need to wait so that terminal does not just disappear when ended.
echo Game ended! You can now close this terminal.
pause >nul
