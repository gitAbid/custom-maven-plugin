# **Tag:0.0.1-SNAPSHOT** [![pipeline status](https://sourcecontrol.hsenidmobile.com/core/m1/sdp/badges/0.0.1-SNAPSHOT/pipeline.svg)](https://sourcecontrol.hsenidmobile.com/core/m1/sdp/-/commits/0.0.1-SNAPSHOT)

* M1-Digital Office **0.0.1-SNAPSHOT** is available for DA testing.


## GIT Location

* **Branch**: main

* **Tag:**  0.0.1-SNAPSHOT


## How to checkout

```
 git clone ssh://git@sourcecontrol.hsenidmobile.com:2222/core/m1/sdp.git
 git checkout  0.0.1-SNAPSHOT

```
## Dependencies
### in-connector
```
 git clone ssh://git@sourcecontrol.hsenidmobile.com:2222/core/m1/in-connector.git
 git checkout  0.0.1-SNAPSHOT

```

## Prerequisites

* OpenJDK-17.0.2
* Maven 3.6.3
* MariaDB 10.11.3
* Docker 24.0.5
* Docker Compose 1.29.2

## Module Released
* middleware
* dataloader

## How to build and deploy

* Please use the CI/CD pipeline for the build and deployments.


## Dockerized Deployments
1. Goto `/sdp/scripts/docker/module-compose` directory
2. Configure the env file mentioned in `docker-compose.yml` file
3. Configure the volumes mentioned in `docker-compose.yml` file
4. Run `docker-compose up` to run all the modules

## Patch Details:

* Configuration changes can be found in SDP-dev [{{old_tag}} to 0.0.1-SNAPSHOT](https://sourcecontrol.hsenidmobile.com/core/m1/sdp-dev/-/compare/{{old_tag}}...0.0.1-SNAPSHOT)

## Features
* BundleSubscription feature implementation

## Enhancement
* Removed double quota from dataloader and middleware env files

## Bug Fixes
*

## Areas to test

* Mentioned  bug fixes  in released modules


## Limitation / known issues
* N.A
