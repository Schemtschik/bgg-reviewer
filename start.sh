cd build/libs
nohup java -jar bgg-reviewer-1.0.0.jar &>/dev/null &
echo $! > ../../pid
