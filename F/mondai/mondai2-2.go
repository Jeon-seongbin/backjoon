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

// 2-3
func Mondai2_2() {
	resp, err := http.Get("https://cdn.kibe.la/media/shared/12170/2363b70f-43ae-4e6b-9124-4f128d9fc291/27501/attachment.txt")

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

	fmt.Println("1")
	// PEM形式の公開鍵をファイルから読み込む
	pemBytes, err := ioutil.ReadFile("mondai2-2.pem")
	if err != nil {
		fmt.Println("2")
		log.Fatalf("Failed to read PEM file: %v", err)
	}
	fmt.Println("3")
	// PEMブロックをパースする
	block, _ := pem.Decode(pemBytes)
	if block == nil {
		log.Fatalf("Failed to parse PEM block")
	}

	fmt.Println("5")
	// RSA公開鍵を抽出する
	pubKeyInterface, err := x509.ParsePKCS1PrivateKey(block.Bytes)
	publicKey := &pubKeyInterface.PublicKey

	if err != nil {
		log.Fatalf("Failed to parse PKIX public key: %v", err)
	}
	for _, value := range values {
		token, err := jwt.Parse(value, func(token *jwt.Token) (interface{}, error) {
			return publicKey, nil
		})

		if err != nil {
			continue
		}

		if token.Valid {
			fmt.Println(value)
		}
	}

}
