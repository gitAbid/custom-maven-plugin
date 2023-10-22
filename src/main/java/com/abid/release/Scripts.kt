package com.abid.release

const val gitLastTagCommand = "git describe --abbrev=0 --tags"
const val gitSecondTagCommand = "git for-each-ref --sort=taggerdate --format '%(refname:short)' refs/tags | tail -n 2 | head -n 1 | sed 's/^refs\\/tags\\///'\n"