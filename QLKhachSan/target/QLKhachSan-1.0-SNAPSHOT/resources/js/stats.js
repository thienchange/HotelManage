/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`;
}

function loaiChart(id, loaiLabels = [], loaiInfo = []) {
    const data = {
        labels: loaiLabels,
        datasets: [{
                label: 'Thống kê phòng',
                data: loaiInfo,
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function phongChart(id, phongLabels = [], phongInfo = []) {
    let colors = [];
    for(let i = 0; i < phongInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: phongLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo từng phòng',
                data: phongInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'line',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function phongMonthChart(id, phongLabels = [], phongInfo = []) {
    let colors = [];
    for(let i = 0; i < phongInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: phongLabels,
        datasets: [{
                label: 'Thống kê doanh thu phòng theo tháng',
                data: phongInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function MonthChart(id, dtLabels = [], dtInfo = []) {
    let colors = [];
    for(let i = 0; i < dtInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: dtLabels,
        datasets: [{
                label: 'Thống kê tổng doanh thu tháng',
                data: dtInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function dichVuChart(id, dvLabels = [], dvInfo = []) {
    let colors = [];
    for(let i = 0; i < dvInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: dvLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo từng dịch vụ',
                data: dvInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'line',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function dichVuMonthStatsChart(id, dvLabels = [], dvInfo = []) {
    let colors = [];
    for(let i = 0; i < dvInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: dvLabels,
        datasets: [{
                label: 'Thống kê doanh thu dịch vụ theo tháng',
                data: dvInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function khachStatsChart(id, khLabels = [], khInfo = []) {
    let colors = [];
    for(let i = 0; i < khInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: khLabels,
        datasets: [{
                label: 'Thống kê số khách hàng theo tháng',
                data: khInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function khPhongStatsChart(id, khLabels = [], khInfo = []) {
    let colors = [];
    for(let i = 0; i < khInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: khLabels,
        datasets: [{
                label: 'Thống kê số khách hàng theo phòng',
                data: khInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}