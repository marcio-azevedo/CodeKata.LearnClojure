(ns company-financial-statements-processor.gSpreadsheetClient
  (:require [clj-http.client :as client])
  (:require [cheshire.core :as cheshire :refer :all])
  ;(:require [google-apps-clj :as gApi])
  )

  (def gSpreadsheetApi "https://sheets.googleapis.com/v4/spreadsheets/")

  ;; ### Auth ###
  ;; https://developers.google.com/sheets/api/quickstart/java#step_3_set_up_the_sample


  ; https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}
  ; PUT https://sheets.googleapis.com/v4/spreadsheets/spreadsheetId/values/Sheet1!A1:D5?valueInputOption=USER_ENTERED
  ; {
  ;    "range": "Sheet1!A1:D5",
  ;    "majorDimension": "ROWS",
  ;    "values": [
  ;      ["Item", "Cost", "Stocked", "Ship Date"],
  ;      ["Wheel", "$20.50", "4", "3/1/2016"],
  ;      ["Door", "$15", "2", "3/15/2016"],
  ;      ["Engine", "$100", "1", "3/20/2016"],
  ;      ["Totals", "=SUM(B2:B4)", "=SUM(C2:C4)", "=MAX(D2:D4)"]
  ;    ],
  ; }

  (comment 
  (defn updateSpreadsheetWithFinancials [metrics spreadsheetId]
    (let [symbol (:symbol metrics)
          financials (:financials metrics)
          totalYears (count financials)
          url (str gSpreadsheetApi spreadsheetId)
          ]
      ;((client/put url {:body "my PUT body"}))
      )
    )
  )
