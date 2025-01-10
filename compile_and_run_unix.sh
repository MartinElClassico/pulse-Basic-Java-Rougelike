#!/bin/bash
# Shell script to compile Java files into .class binaries on Linux/Mac.

# Holds source directory to compile from and output directory to compile to.
SRC_DIR="$(dirname "$0")/DragonTreasure/src"
OUT_DIR="$(dirname "$0")/DragonTreasure/bin"
MAIN_FILE="main.DragonTreasure"

# Remove old output directory and create a new one.
if [ -d "$OUT_DIR" ]; then
    rm -rf "$OUT_DIR"
fi
mkdir -p "$OUT_DIR"

# Compile all .java files.
echo "Compiling Java source files..."
javac -d "$OUT_DIR" -sourcepath "$SRC_DIR" $(find "$SRC_DIR" -name "*.java")
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

echo
echo "Compilation completed successfully."
read -p "Press Enter to play the game, or Ctrl+C to quit."

# Run the game.
echo
echo "Running the game..."
java -cp "$OUT_DIR" "$MAIN_FILE"
echo
echo "Game ended! You can now close this terminal."