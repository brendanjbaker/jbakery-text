#!/bin/bash

set -euxo pipefail

path_script=$(readlink -f "$0")
path_root=$(dirname $(dirname "$path_script"))
project=jbakery-text
project_type=jar
path_release_directory=~/jbakery/$project
path_repository=$(mktemp -d)
repository_url=file://$path_repository

export GPG_TTY=$(tty)
export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))

pushd $path_root/$project
mvn clean deploy -Pdeploy -Drepository.url=$repository_url
popd

path_jar=$(find $path_repository | grep -i \\.$project_type$ | sort -n | head -n 1)
path_jar_directory=$(dirname $path_jar)
path_jar_filename=$(basename $path_jar)
path_jar_filename=${path_jar_filename%.*}

pushd $path_jar_directory
mkdir -p $path_release_directory
path_artifact=$path_release_directory/$path_jar_filename.jar
jar -cvf $path_artifact *
popd

if [ -d /c/Users/Baker ]; then
	mkdir -p /c/Users/Baker/jbakery/$project/release
	cp $path_artifact /c/Users/Baker/jbakery/$project/release
fi
