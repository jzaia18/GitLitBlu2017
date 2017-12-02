all: src/main/java/gitlitblu/GitLitBlu.java
	 javac -cp core.jar src/main/java/gitlitblu/GitLitBlu.java

run: all
	java src/main/java/gitlitblue/GitLitBlu
