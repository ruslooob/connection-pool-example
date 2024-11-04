import http from 'k6/http';
import {check, sleep} from 'k6';
import {Counter} from 'k6/metrics';

export let options = {
    stages: [
        {duration: '1m', target: 50},
        {duration: '2m', target: 100},
        {duration: '2m', target: 200},
        {duration: '5m', target: 200},
        {duration: '2m', target: 0},
    ],
};

let errorCounter = new Counter('errors');

function randomString(length) {
    let result = '';
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    for (let i = 0; i < length; i++) {
        result += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return result;
}

function randomInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

export default function () {
    let createUserPayload = JSON.stringify({
        name: randomString(10),
    });

    let createUserHeaders = {'Content-Type': 'application/json'};
    let createUserRes = http.post('http://localhost:8080/create-user', createUserPayload, {headers: createUserHeaders});

    check(createUserRes, {
        'create-user: status is 200': (r) => r.status === 200,
    }) || errorCounter.add(1);

    let addMoneyPayload = JSON.stringify({
        userId: 1, // You can parameterize or fetch actual user IDs if needed
        moneysToAdd: randomInteger(10, 100),
    });

    let addMoneyHeaders = {'Content-Type': 'application/json'};
    let addMoneyRes = http.post('http://localhost:8080/add-money', addMoneyPayload, {headers: addMoneyHeaders});

    check(addMoneyRes, {
        'add-money: status is 200': (r) => r.status === 200,
    }) || errorCounter.add(1);

    sleep(1);
}
