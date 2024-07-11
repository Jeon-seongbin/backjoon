package mondai

import (
	"crypto/x509"
	"encoding/pem"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strings"

	"github.com/dgrijalva/jwt-go"
)

// 2-2
func Mondai2_1() {
	resp, err := http.Get("https://cdn.kibe.la/media/shared/12170/2363b70f-43ae-4e6b-9124-4f128d9fc291/27560/attachment.txt")

	if err != nil {
		panic(err)
	}

	defer resp.Body.Close()

	// 결과 출력
	data, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		panic(err)
	}

	// fmt.Printf("%s\n", string(data))
	values := strings.Split(string(data), "\n")

	// PEM形式の公開鍵をファイルから読み込む
	pemBytes, err := ioutil.ReadFile("jwts_rsa.pem")
	if err != nil {
		log.Fatalf("Failed to read PEM file: %v", err)
	}

	// PEMブロックをパースする
	block, _ := pem.Decode(pemBytes)
	if block == nil {
		log.Fatalf("Failed to parse PEM block")
	}

	// RSA公開鍵を抽出する
	pubKeyInterface, err := x509.ParsePKCS1PublicKey(block.Bytes)
	if err != nil {
		log.Fatalf("Failed to parse PKIX public key: %v", err)
	}

	for _, value := range values {
		token, err := jwt.Parse(value, func(token *jwt.Token) (interface{}, error) {
			return pubKeyInterface, nil
		})
		if err != nil {
			continue
		}

		if token.Valid {
			fmt.Println(value)
		}
	}

}
