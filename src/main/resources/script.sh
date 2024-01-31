#!/bin/bash

mkdir certs
cd ./certs
sleep 3
 openssl genrsa -out keypair.pem 2048
sleep 2
 # extract public key
 openssl rsa -in keypair.pem -pubout -out public.pem
sleep 2
 # create private key in PKCS#8 format
 openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
