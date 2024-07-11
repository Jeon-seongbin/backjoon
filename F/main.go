package main

import "example.com/m/mondai"

type User struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func main() {
	mondai.Mondai2_1()
	mondai.Mondai2_2()

	// http.HandleFunc("/login", func(w http.ResponseWriter, r *http.Request) {
	// })

	// mux := http.NewServeMux()

	// mux.HandleFunc("/login", func(w http.ResponseWriter, r *http.Request) {
	// 	user := User{}
	// 	if err := json.NewDecoder(r.Body).Decode(&user); err != nil {
	// 		return
	// 	}

	// 	fmt.Println(user.Username)
	// 	fmt.Println(user.Password)

	// })

	// mux.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
	// 	fmt.Println("start")
	// 	w.WriteHeader(200)
	// 	return
	// })

	// if err := http.ListenAndServe(":443", mux); err != nil {
	// 	log.Fatal(err)
	// }

}
