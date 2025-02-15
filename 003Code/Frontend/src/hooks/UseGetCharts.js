import { useQuery } from 'react-query';
import {
  getCosts,
  getPredictFoods,
  getPredictMenus,
  getPredictUsers,
  getTodayPop,
  getUserPop,
} from '../api/apis';
import { ConfigWithToken } from '../utils/utils';

const UseGetCharts = () => {
  const config = ConfigWithToken();
  const today = new Date();

  const todaydates = {
    today: new Date(),
    year: today.getFullYear(),
    month: today.toLocaleString('en-US', {
      month: 'long',
    }),
    day: today.getDate(),
  };

  // predict-menus
  const { data: predictMenus, isLoading } = useQuery(['getPredict', config], () =>
    getPredictMenus(config)
  );
  const predictMenusArray = Object.entries(!isLoading && predictMenus);

  // predict-foods
  const { data: predictfoods, isLoading: predictfoodsloading } = useQuery(
    ['getpredictfoods', config],
    () => getPredictFoods(config)
  );
  const predictfoodsArray = Object.entries(!predictfoodsloading && predictfoods);

  // reservation-infos
  const { data: reservation, isLoading: reservationloading } = useQuery(
    ['getUserPop', config],
    () => getUserPop(config)
  );
  const reservationArray = Object.entries(!reservationloading && reservation).slice(1);

  // today-pop
  const { data: todaypop, isLoading: todaypoploading } = useQuery(
    ['gettoday', config],
    () => getTodayPop(config)
  );

  const { data: predictUser, isLoading: predictUserLoading } = useQuery(
    ['getpredictuser', config],
    () => getPredictUsers(config)
  );

  const { data: marketCost, isLoading: costLoading } = useQuery(
    ['getCosts', config],
    () => getCosts(config)
  );

  return {
    predictMenusArray,
    predictfoodsArray,
    reservationArray,
    todaypop: !todaypoploading && todaypop,
    todaydates,
    predictUser: !predictUserLoading && predictUser,
    marketCost: !costLoading && marketCost,
  };
};

export default UseGetCharts;
