import Title from '../general/Title';
import ApexCharts from 'react-apexcharts';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { ConfigWithToken, ManagerBaseApi } from '../../auth/authConfig';
import { c_color } from '../../styles/global';

const FoodNeccesaryChart = () => {
  const [predict, setPredict] = useState([]);
  const config = ConfigWithToken();
  const predictArray = Object.entries(predict);

  useEffect(() => {
    axios
      .get(`${ManagerBaseApi}/state/predict/food`, config)
      .then((res) => setPredict(res.data))
      .catch((err) => {
        if (err.response.status === 403) {
        }
      });
  }, []);

  return (
    <>
      <Title>
        <span style={c_color}>익일 필요 식재료</span>
      </Title>
      <ApexCharts
        type="bar"
        series={[
          {
            name: '무게(g)',
            data: predictArray.map((a) => a[1]),
          },
        ]}
        height={270}
        options={{
          chart: {
            toolbar: { show: false },
            stacked: true,
          },
          stroke: {
            width: 1,
            colors: ['#fff'],
          },
          plotOptions: {
            bar: {
              horizontal: false,
            },
          },
          xaxis: {
            categories: predictArray.map((a) => a[0]),
          },
          yaxis: {
            labels: {
              formatter: (val) => {
                return val + 'g';
              },
            },
          },
          fill: {
            opacity: 1,
          },
          colors: ['#8D95EB'],
        }}
      />
    </>
  );
};

export default FoodNeccesaryChart;