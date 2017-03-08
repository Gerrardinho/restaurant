import { RestaurantClientPage } from './app.po';

describe('restaurant-client App', () => {
  let page: RestaurantClientPage;

  beforeEach(() => {
    page = new RestaurantClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
