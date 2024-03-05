<%@page import="java.util.Date"%>
<%@page import="com.org.weatherdto.Weathering"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Weatherer</title>
	<link rel='icon' href="https://th.bing.com/th/id/R.770b805d5c99c7931366c2e84e88f251?rik=khgO%2bY1Hh3BT9w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-weather-iconsymbolsiconsapple-iosiosios-8-iconsios-8-721522596142qx4ep.png&ehk=6msbAydV7X6D4bO8zvLC664aXwKOdBU17dwrHcKxaAg%3d&risl=&pid=ImgRaw&r=0">
	
	<style type="text/css">
		 
	@import url('https://fonts.googleapis.com/css2?family=Lemon&family=Roboto&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Kode+Mono:wght@400..700&display=swap');

*{
    padding: 0;
    margin: 0;
    font-family: 'Kode Mono';
}
body{
    height: 97dvh;
    display: flex;
    flex-direction:column;
    align-items: center;
    justify-content: center;
    background-image: url("https://img.freepik.com/free-vector/gorgeous-clouds-background-with-blue-sky-design_1017-25501.jpg");
    background-repeat: no-repeat;
    background-position:center;
    background-size: cover;
}

#navbar{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 8vh;
    text-align: center;
    background-color: rgb(0, 255, 255,0.3);
    font-family: 'Lemon';
    user-select: none;
}

#navbar>h1{
    font-size: 3rem;
}

#container{
    width:40vw;
    height: auto;
    border:2px solid black;
    margin:auto;
    padding:10px;
    background-color: rgb(245, 245, 245,0.5);
    font-size: 16px;
    border-radius: 15px 5px 15px 5px;
    user-select: none;
}

#container form{
    display: flex;
    height:2rem;
    border: 1px solid black;
    padding:2px;
}

#searchbar{
    flex: 3;
    border: none;
    outline: none;
    font-size: 1rem;
    background-color: rgb(255, 255, 255,0.6);
}

#submitbtn{
    flex: 1;
    outline: none;
    border: none;
    background-color: skyblue;
    font-size: 1rem;
    font-family: 'Roboto';
    font-weight: 550;
}

#submitbtn:hover{
    cursor: pointer;
    background-color: rgb(100, 200, 240);
    color: black;
}

.weather-details{
    margin: 15px;
    position: relative;
    padding:6px;
}

.location-time{
    display: inline-block;
    position: absolute;
    right: 0px;
    text-align: right;
}

.temp-and-icon{
    display: flex;
    height: 100%;
}

.weather-details #temp{
    overflow: hidden;
    font-size: 3em;
    font-weight: bold;
}
		
	
	</style>
	
</head>
<body>
	<%
		Weathering weather = Weathering.getWeatherObject();
	%>
	
    <header>
        <nav id="navbar">
            <h1>KNOW YOUR WEATHER</h1>
        </nav>
    </header>

    <main>
    
    <%	if(request.getAttribute("isLocValid") != null && request.getAttribute("isLocValid").equals("false")){	%>
    
    <h2 style="color:red; text-align:center;">Invalid Location</h2>
    
    <% request.setAttribute("isLocValid", "");
    }%>
    
        <div id="container">

            <form action="weatherDetails">
                <input type="text" name="location" required placeholder="Enter Location" id="searchbar">
                <br>
                <button type="submit" id="submitbtn">Search</button>
            </form>

            <div class="weather-details">
                <div class="temp-and-icon">
                    <div class="location-time">
                        <h3><%=weather.getTime()%> IST</h3>
                        <h4><%=weather.getDate() %></h4> <br>
                        <h3 id="location"><%= weather.getLoc_city() %>, <%= weather.getLoc_country()%> </h3>
                    </div>
					<%String iconId="http://openweathermap.org/img/w/"+weather.getIcon_id()+".png";%>
                    <span> <img src=<%=iconId %> alt="icon"></span>
                    <span id="temp"><%= weather.getTemp()%>°C</span>

                </div>

                <div>
                    <span id="feelsLike">Feels Like <%= weather.getFeels_like()%>°C ,</span>
                    <span id="atmosphere"><%= weather.getAtmosphere() %></span>
                    <br><br>
                    <span id="wind">Wind Speed: <%= weather.getWindSpeed() +" KM/H" %></span>
                    <br>
                    <span id="humidity">Humidity: <%= weather.getHumidity()%>%</span>
                    <br>
                    <span id="visibility">Visibility: <%= weather.getVisibility()%>km </span>
                    <br>
                    <span id="pressure">Pressure: <%= weather.getPressure()%> hPa </span>

                </div>
            </div>

        </div>
    </main>
	
	
</body>
</html>