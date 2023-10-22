package com.abid.release

const val gitGetAllTags = """git for-each-ref --sort=taggerdate --format %(refname:short) refs/tags"""