import http from 'k6/http';
import {check, sleep} from 'k6';


let stages = [];
for (let i = 100; i <= 15_000; i += 500) {
    stages.push({duration: '10s', target: i});
}

export let options = {
    stages: stages,
    thresholds: {
        http_req_failed: [{threshold: 'rate<0.01', abortOnFail: true}],
        http_req_duration: [{threshold: 'p(99) < 1500', abortOnFail: true}]
    },
};

const userPayloads = Array.from({length: 1000},
    () => `{"name":"user${Math.floor(Math.random() * 100000)}"}`);

function getRandomPayload() {
    return userPayloads[Math.floor(Math.random() * userPayloads.length)];
}

const headers = {headers: {'Content-Type': 'application/json'}};

export default function () {
    let createUserRes = http.post('http://localhost:8080/create-user', getRandomPayload(), headers);

    check(createUserRes, {
        'create-user: status is 200': (r) => r.status === 200,
    });

    sleep(1);
}