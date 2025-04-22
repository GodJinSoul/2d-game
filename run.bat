@echo off
echo Compiling Java files...
dir /S /B src\*.java > sources.txt
javac -d bin @sources.txt
echo Done.
java -cp "bin;res" src.game.core.Main
pause