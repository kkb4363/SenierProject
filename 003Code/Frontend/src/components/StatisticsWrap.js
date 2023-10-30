import styled from 'styled-components';
import Statistics from './general/Statistics';
import UseGetCharts from '../hooks/UseGetCharts';
import UseCalculateFood from '../hooks/UseCalculateFood';
import visitorImg from '../image/working.png';
import { useState } from 'react';
import UseCompareReservation from '../hooks/dashboard_statistics/UseCompareReservation';
import UseUserPop from '../hooks/dashboard_statistics/UseUserPop';

const Wrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  place-items: center;
  grid-gap: 30px;

  width: 100%;
  height: 100%;
`;

const Visitor = () => {
  return <img src={visitorImg} width={'90%'} height={'100%'} />;
};

const StatisticsWrap = () => {
  const [chipRedColor, setChipRedColor] = useState({
    reservation: false,
    user: false,
    cost: false,
    minus: false,
  });
  const { reservationArray, predictUser } = UseGetCharts();
  const { calculatedValue, calculatedWeeksValue } = UseCalculateFood({
    setChipFn: setChipRedColor,
  });
  const { reservationsComparedToYesterday } = UseCompareReservation({
    setChipFn: setChipRedColor,
    data: reservationArray,
  });
  const { todaypop, comparedpop } = UseUserPop({
    setChipFn: setChipRedColor,
  });

  const calculatedIngredientsValue = isNaN(calculatedValue) ? 0 : calculatedValue;

  const statistics_datas = [
    {
      title: '이용자',
      data: `${todaypop}명`,
      date: '금일',
      icon: <Visitor />,
      chip: `${comparedpop}명`,
      chipcolor: chipRedColor.user,
    },
    {
      title: '매출액',
      data: '200만원',
      date: '금일',
      chip: '+15만원',
      chipcolor: false,
    },
    {
      title: '식재료 절약양',
      data: `${calculatedIngredientsValue}kg`,
      date: '금일',
      chip: `${calculatedWeeksValue}kg`,
      chipcolor: chipRedColor.minus,
      isWeek: true,
    },
    {
      title: '예약자',
      data: `${predictUser}명`,
      date: '익일',
      chip: reservationsComparedToYesterday + '명',
      chipcolor: chipRedColor.reservation,
    },
  ];

  return (
    <Wrapper>
      {statistics_datas.map((item, idx) => (
        <Statistics key={idx + 'statisticskey'} {...item} />
      ))}
    </Wrapper>
  );
};

export default StatisticsWrap;