(ns company-financial-statements-processor.model)

  (def metrics {:revenue                   []
                :totalShares               []
                :eps                       []
                :fcf                       []
                :equity                    []
                :profitMargin              []
                :totalShareholdersEquity   []
                :totalShEquityPerShare     []
                :revenueGrowth1yr          10.0
                :revenueGrowth3yr          10.0
                :revenueGrowth5yr          10.0
                :revenueGrowth9yr          10.0
                :epsGrowth1yr              10.0
                :epsGrowth3yr              10.0
                :epsGrowth5yr              10.0
                :epsGrowth9yr              10.0
                :fcfGrowth1yr              10.0
                :fcfGrowth3yr              10.0
                :fcfGrowth5yr              10.0
                :fcfGrowth9yr              10.0
                :equityGrowth1yr           10.0
                :equityGrowth3yr           10.0
                :equityGrowth5yr           10.0
                :equityGrowth9yr           10.0
                }
    )

  ; https://clojure.org/reference/datatypes
  (deftype Company [name        ;"Coca-Cola Company"
                    symbol      ;"KO"
                    exchange    ;"NYSE"
                    metrics     ;metrics
                    stockPrice  ;9.0
                    ]
    )
  ;; (->Company {:name "Coca-Cola Company" :symbol "KO" :exchange "NYSE" :metrics "metrics" :stockPrice 9.0})
