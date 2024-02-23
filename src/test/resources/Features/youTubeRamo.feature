@UA1
  Feature:US_01 Kullanıcı Youtube Kanalında Video İzleyebilmeli
    Scenario: TC_01 Kullanıc Youtube Video izlemek için Video Tıklayabilmeli
      Given Kullanıcı YouTube Ana Sayfasına Gider
      Then Kullanıcı Search Kısmında Arama Yapabilmeli
      And  Kullanıcı Gelen Aramalar Sonucu Video Tıklayabilmeli
      And Kullanıcı Begeni Tusuna Basabilmeli
      And Kullanıcı Abone Olabilmeli
      And Kullanıcı Youtube Kapatır
