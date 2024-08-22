const apiKey = 'ba49b0ebd03dd496854f2123d3bf0407';
const apiUrl = 'https://api.openweathermap.org/data/2.5/weather';

const locationInput = document.getElementById('locationInput');
const searchButton = document.getElementById('searchButton');
const locationElement = document.getElementById('location');
const temperatureElement = document.getElementById('temperature');
const descriptionElement = document.getElementById('description');
const p=document.getElementById('p1');

searchButton.addEventListener('click', () => {
    const location = locationInput.value;
    if (location) {
        fetchWeather(location);
    }
});

// Reset to default when the input is edited
locationInput.addEventListener('input', () => {
    resetToDefault();
});
//k
locationInput.addEventListener("keypress",function(event){
   
    if (event.key === "Enter") {
        fetchWeather(locationInput.value);

        document.getElementById("searchButton").click();
      }
})
//k
function fetchWeather(location) {
    const url = `${apiUrl}?q=${location}&appid=${apiKey}&units=metric`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const weather = data.weather[0].main.toLowerCase();
            
            locationElement.textContent = data.name;
            temperatureElement.textContent = `${Math.round(data.main.temp)}°C`;
            descriptionElement.textContent = data.weather[0].description;

            // Update background image based on weather
            switch (weather) {
                case 'clear':
                    document.body.style.backgroundImage = "url('clear.jpg')";
                    break;
                case 'clouds':
                    document.body.style.backgroundImage = "url('Clouds.jpg')";
                    break;
                case 'rain':
                    document.body.style.backgroundImage = "url('rain.jpg')";
                    break;
                case 'snow':
                    document.body.style.backgroundImage = "url('snow.jpg')";
                    break;
                case 'thunderstorm':
                    document.body.style.backgroundImage = "url('thunderstorm.jpg')";
                    break;
                case 'fog':
                case 'mist':
                case 'haze':
                    document.body.style.backgroundImage = "url('fog.jpg')";
                    break;
                default:
                    document.body.style.backgroundImage = "url('default.jpg')"; // Default background
                    break;
            }
        })
        .catch(() => {
           // console.error('Error fetching weather data:', error);
           p.textContent = "Please check your location or try again later.";
        });
}

function resetToDefault() {
    // Clear weather information
    locationElement.textContent = '';
    temperatureElement.textContent = '';
    descriptionElement.textContent = '';
    p.textContent = '';

    // Reset background image to default
    document.body.style.backgroundImage = "url('default.jpg')";
}