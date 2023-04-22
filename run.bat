@echo off
javac *.java
ECHO normal file is called Normal.arxml
ECHO empty file is called Empty.arxml
ECHO invalid file is called new.c 
ECHO will test them in the same sequence
java Test Normal.arxml
java Test Empty.arxml
java Test new.c
pause



