function fetchData(callback) {
    setTimeout(() => {
        const data = 'Data fetched successfully!';
        callback(data);
    }, 2000);
}

const handleData = (data) => {
    console.log(data);
};

fetchData(handleData);

function fetchData() {
    return new Promise((resolve) => {
        setTimeout(() => {
            const data = 'Data fetched successfully!';
            resolve(data);
        }, 2000);
    });
}

fetchData().then((data) => {
    console.log(data);
});
