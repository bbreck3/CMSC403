export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"

alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool'

alias grun='java org.antlr.v4.runtime.misc.TestRig'

