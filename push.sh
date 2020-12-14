#!/usr/bin/env bash

set -e
COMMENT_LOG=$1

if [ ! "$COMMENT_LOG" ]; then
  echo "comment use default ."
  COMMENT_LOG=.
fi

git add . && git commit -m $COMMENT_LOG && git push origin master