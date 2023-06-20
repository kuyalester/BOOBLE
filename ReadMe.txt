BOOBLE V.5.0.0

This is a game variant of "Who Wants To Be a Millionaire".

------------------------------------------------------------------------------
Running Executable Jar in Command Prompt:

1. In your directory where the executable jar is located, type "cmd" in the address bar and press ENTER to open the command prompt directed to the folder.

2. Then, type the following command in the cmd to run the jar file.

java --module-path "javaFX\lib" --add-modules javafx.controls,javafx.fxml,javafx.media,poi.ooxml,poi  -jar BOOBLE.jar

Note: BOOBLE.jar is the file name of the jar file.

------------------------------------------------------------------------------

Compiling/Execution of Source code in command prompt:

1. Navigate to the Group5_SourceCode, type "cmd" in the address bar and press ENTER to open the command prompt directed to the folder.

2. Then, type the following command in the cmd to compile the source code. 

    javac --module-path "javaFX\lib" --add-modules javafx.controls,javafx.fxml,javafx.media,poi.ooxml,poi src/*.java -d classes

3. Next, type the following command in the cmd to run the program.

    java --module-path "javaFX\lib" --add-modules javafx.controls,javafx.fxml,javafx.media,poi.ooxml,poi  -cp classes Main

------------------------------------------------------------------------------

Running the app using the stand alone exe file:

1. Double click on the Booble.exe application.

------------------------------------------------------------------------------


