REM bash script to compile the java files into .class binaries for users on windows machines.

REM we do not want it to print this script to the user, thus echo off.
@echo off
REM Holds source directiory to compile from and output direction to compile to.
set SRC_DIR=src
set OUT_DIR=bin

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
java -cp "%OUT_DIR%" DragonTreasure
