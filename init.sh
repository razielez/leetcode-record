#!/usr/bin/env bash

set -e
RPOBLEM_NUM=$1

if [ ! "$RPOBLEM_NUM" ]; then
  echo "please input problem num"
  exit
fi
echo "init problem num"+"$RPOBLEM_NUM"

CPP_PATH=./$RPOBLEM_NUM/cpp/
mkdir -p ./"$RPOBLEM_NUM"/cpp
mkdir -p ./"$RPOBLEM_NUM"/java

cd "$CPP_PATH" && leetcode show -gx "$RPOBLEM_NUM" -l cpp



