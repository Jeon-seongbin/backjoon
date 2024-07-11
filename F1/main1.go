package main

/*
import (
	"net/http"

	"github.com/labstack/echo/v4"
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

type HotelReserv struct {
	ID        int      `json:"id"`
	Name      string   `json:"name"`
	RoomId    int      `json:"room_id"`
	Price     int      `json:"price"`
	Condition []string `json:"condition"`
}

func main() {
	e := echo.New()

	e.GET("/hotel-reservation-en/hotels", func(c echo.Context) error {
		token := c.Request().Header.Get("X-Access-Token")

		// If token is empty, return an unauthorized error
		// if token == "" {
		// 	return c.JSON(http.StatusUnauthorized, map[string]string{"error": "Unauthorized"})
		// }

		hotelSearchInput := HotelSearchInput{}
		err := c.Bind(&hotelSearchInput)
		if err != nil {
			return c.String(http.StatusBadRequest, "bad request")
		}

		return c.JSON(http.StatusOK, map[string]string{"token": token})
	})

	e.POST("/hotel-reservation-en/reservation", func(c echo.Context) error {
		token := c.Request().Header.Get("X-Access-Token")

		// If token is empty, return an unauthorized error
		// if token == "" {
		// 	return c.JSON(http.StatusUnauthorized, map[string]string{"error": "Unauthorized"})
		// }

		hotelSearchInput := HotelSearchInput{}
		err := c.Bind(&hotelSearchInput)
		if err != nil {
			return c.String(http.StatusBadRequest, "bad request")
		}

		return c.JSON(http.StatusOK, map[string]string{"token": token})
	})

	e.Start(":8080")
}
*/
/*
var (
	requestCount int
	mutex        sync.Mutex
)

type User struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

type Token struct {
	Token string `json:"token"`
}

type Flag struct {
	Flag string `json:"flag"`
}

type CandleRequest struct {
	Code  string `param:"code"`
	Year  int    `param:"year"`
	Month int    `param:"month"`
	Day   int    `param:"day"`
	Hour  int    `param:"hour"`
}

type CandleResponse struct {
	Open  string `json:"open"`
	High  int    `json:"high"`
	Low   int    `json:"low"`
	Close int    `json:"close"`
}

func main() {
	e := echo.New()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	e.GET("/", func(c echo.Context) error {
		return c.String(http.StatusOK, "Hello, World!")
	})

	e.PUT("/login", func(c echo.Context) error {

		var user User
		err := c.Bind(&user)
		if err != nil {
			return c.String(http.StatusBadRequest, "bad request")
		}

		sha1 := sha1.New()
		io.WriteString(sha1, user.Username+user.Password)

		t := &Token{
			Token: hex.EncodeToString(sha1.Sum(nil)),
		}
		c.Response().Header().Set(echo.HeaderContentType, echo.MIMEApplicationJSONCharsetUTF8)
		c.Response().WriteHeader(http.StatusOK)
		return json.NewEncoder(c.Response()).Encode(t)
	})

	e.PUT("/flag", func(c echo.Context) error {
		var flag Flag
		err := c.Bind(&flag)
		if err != nil {
			return c.String(http.StatusBadRequest, "bad request")
		}

		return c.String(http.StatusOK, "flag")
	})

	e.GET("/candle", func(c echo.Context) error {
		mutex.Lock()
		defer mutex.Unlock()

		candleRequest := CandleRequest{}
		if err := c.Bind(&candleRequest); err != nil {
			return c.String(http.StatusBadRequest, "bad request")
		}
		requestCount++

		if requestCount == 3 {
			// 세 번째 요청일 때 수행할 작업
			requestCount = 0 // 카운터 리셋

			return c.String(http.StatusOK, "This is the third request. Special action performed!")
		}

		fmt.Println(candleRequest)
		return c.String(http.StatusOK, "flag")
	})
	e.Logger.Fatal(e.Start(":8080"))
}
*/
