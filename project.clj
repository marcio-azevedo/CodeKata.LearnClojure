(defproject company-financial-statements-processor "0.1.0"
  :description "Company Financial Statements Processor: An app to extract Company's key financial metrics and export into Google Spreadsheets"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.10.1"]
                 [cheshire "5.10.0"]
                 [google-apps-clj "0.6.1"]
                 ;[com.google.api-client/google-api-client "1.30.9"]
                 ]
  ; :main ^:skip-aot company-financial-statements-processor.core
)
