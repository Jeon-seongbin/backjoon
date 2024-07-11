package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"strconv"
)

type HotelSearchRequest struct {
	Keyword   string   `json:"keyword"`
	Checkin   string   `json:"checkin"`
	Checkout  string   `json:"checkout"`
	Number    int      `json:"number"`
	Condition []string `json:"condition"`
}

type HotelSearchResponse struct {
	ID         int      `json:"id"`
	Name       string   `json:"name"`
	Prefecture int      `json:"prefecture"`
	Address    string   `json:"address"`
	Condition  []string `json:"condition"`
	Rooms      Rooms    `json:"rooms"`
	Plans      Plans    `json:"plans"`
}

type Rooms struct {
	ID        int      `json:"id"`
	Name      string   `json:"name"`
	Capacity  int      `json:"capacity"`
	Count     int      `json:"count"`
	Condition []string `json:"condition"`
}

type Plans struct {
	ID        int      `json:"id"`
	Name      string   `json:"name"`
	RoomId    int      `json:"room_id"`
	Price     int      `json:"price"`
	Condition []string `json:"condition"`
}

type HotelReservationRequest struct {
	ID        int      `json:"id"`
	Name      string   `json:"name"`
	RoomId    int      `json:"room_id"`
	Price     int      `json:"price"`
	Condition []string `json:"condition"`
}

func main() {
	run(os.Args[1:])
}

func run(args []string) {
	for i, v := range args {
		fmt.Printf("argv[%d]: %s\n", i, v)

	}
}

func getRequest(header, arg2 string) error {

	var jsonMap map[string]interface{}
	json.Unmarshal([]byte(arg2), &jsonMap)

	url := "https://challenge-server.tracks.run/hotel-reservation-en/hotels?"

	// 요청 생성
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		fmt.Println("Error:", err)
		return nil
	}

	// 헤더 추가
	req.Header.Set("X-Access-Token", header)

	// 클라이언트 생성
	client := &http.Client{}

	// 요청 전송
	resp, err := client.Do(req)
	if err != nil {
		fmt.Println("Error:", err)
		return nil
	}
	defer resp.Body.Close()

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("Error:", err)

	}
	hotelSearchResponse := HotelSearchResponse{}
	err = json.Unmarshal(body, &hotelSearchResponse)
	if err != nil {
		fmt.Printf("Error unmarshaling JSON: %v\n", err)
		return nil
	}
	id := strconv.Itoa(hotelSearchResponse.ID)
	capacity := strconv.Itoa(hotelSearchResponse.Rooms.Capacity)

	price := strconv.Itoa(hotelSearchResponse.Plans.Price)
	result := "The cheapest plan has been successfully reserved.\n" + "- reservation id: " + id + "\n- hotel name:" + hotelSearchResponse.Name + "\n- room name: " + hotelSearchResponse.Rooms.Name + " - " + capacity + " - " + hotelSearchResponse.Rooms.Condition[0] + "\n- plan name: " + hotelSearchResponse.Plans.Name + "\n-total price: " + price
	fmt.Println(string(result))
	return nil
}
