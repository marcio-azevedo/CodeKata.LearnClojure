(ns company-financial-statements-processor.client
  (:require [clj-http.client :as client])
  (:require [cheshire.core :as cheshire :refer :all])
  ;(:require [company-financial-statements-processor.client :as model])
  )

  (def incomeStatementApi "https://financialmodelingprep.com/api/v3/financials/income-statement/")
  (def balanceSheetStatementApi "https://financialmodelingprep.com/api/v3/financials/balance-sheet-statement/")
  (def cashFlowStatementApi "https://financialmodelingprep.com/api/v3/financials/cash-flow-statement/")

  ; get Company Income Statement financial metrics
  (defn getCompanyIncomeStatementMetrics [symbol]
    (try
      (let [url (str incomeStatementApi symbol)]
        (get (cheshire/parse-string (:body (client/get url {:accept :json}))) "financials") ;; https://github.com/dakrone/cheshire#decoding
        )
      (catch Exception e (.getMessage e) println))
    )

  ; get Company Balance Sheet Statement financial metrics
  (defn getCompanyBalanceSheetStatementMetrics [symbol]
    (try
      (let [url (str balanceSheetStatementApi symbol)]
        (get (cheshire/parse-string (:body (client/get url {:accept :json}))) "financials") ;; https://github.com/dakrone/cheshire#decoding
        )
      (catch Exception e (.getMessage e) println))
    )

  ; Company Cash Flow Statement financial metrics
  (defn getCompanyCashFlowStatementMetrics [symbol]
    (try
      (let [url (str cashFlowStatementApi symbol)]
        (get (cheshire/parse-string (:body (client/get url {:accept :json}))) "financials") ;; https://github.com/dakrone/cheshire#decoding
        )
      (catch Exception e (.getMessage e) println))
    )

  ; get Company consolidated financial statement metrics
  (defn getCompanyConsolidatedFinancialStatementMetrics [symbol]
    (let [incomeFinancialMetrics       (getCompanyIncomeStatementMetrics symbol)
          balanceSheetFinancialMetrics (getCompanyBalanceSheetStatementMetrics symbol)
          cashFlowFinancialMetrics     (getCompanyCashFlowStatementMetrics symbol)
          totalYears                   (count incomeFinancialMetrics)
          ]
      {
       :symbol symbol
       :financials 
        (loop [i 0
               metrics {}]
          (if (< i totalYears)
            (recur (inc i)
                   (conj metrics
                         {:date (get (get incomeFinancialMetrics i) "date")
                          :revenue (get (get incomeFinancialMetrics i) "Revenue")
                          :eps (get (get incomeFinancialMetrics i) "EPS")
                          :fcf (get (get cashFlowFinancialMetrics i) "Free Cash Flow")
                          :equity (get (get balanceSheetFinancialMetrics i) "Total shareholders equity")}
                   ))
            metrics
            ))
       }
      )
    )

  ; --
  ; (require '[clj-http.client :as client] '[cheshire.core :as cheshire] '[company-financial-statements-processor.client :as cfsp])
  ; (def incomeStatement (cfsp/getCompanyIncomeStatementMetrics "KO"))
  ; (def balanceSheet (cfsp/getCompanyBalanceSheetStatementMetrics "KO"))
  ; (def cashFlow (cfsp/getCompanyCashFlowStatementMetrics "KO"))
  ; (def metrics (cfsp/getCompanyConsolidatedFinancialStatementMetrics "KO"))

  ; (count incomeStatement) ; number of years
  ; (get incomeStatement 0) ; last year
  ; (get (get incomeStatement 0) "date")
  ; (get cashFlow 0)
  ; (get balanceSheet 0)
  ; (:financials metrics)


  ; --
  ; (require '[company-financial-statements-processor.model :as models])
    ;(->Company {:name "Coca-Cola Company" :symbol symbol :exchange "NYSE" :metrics metrics :stockPrice 9.0})
