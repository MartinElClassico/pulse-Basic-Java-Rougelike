REM bash script to compile the java files into .class binaries for users on windows machines.

@echo off
REM we do not want it to print the rest of this script to the user, thus echo off.

REM Holds source directiory to compile from and output direction to compile to.
set SRC_DIR=src
set OUT_DIR=bin
set MAIN_FILE=DragonTreasure

REM create output directory.
if not exist "%OUT_DIR%" (
    mkdir "%OUT_DIR%"
)

REM find all .java files recursively and compile them one by one.
REM %%f represent each of the found .java files.
for /R "%SRC_DIR%" %%f in (*.java) do (
    echo Compiling %%f
    javac -d "%OUT_DIR%" -sourcepath "%SRC_DIR%" "%%f"
    REM print errors if they fail. Pauses to let player see error code.
    if errorlevel 1 (
        echo.
        echo Compilation failed for: %%f
        pause
        exit /b 1
    )
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
java -cp "%OUT_DIR%" "%MAIN_FILE%"
REM empty lines to distinguish between game and bash script.
echo _
echo _
echo _
REM need to wait so that terminal does not just disappear when ended.
echo Game ended! You can now close this terminal.
pause >nul
