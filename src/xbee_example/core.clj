(ns xbee-example.core
  (:require [clojusc.twig :as logger]
            [xbee.device.xbee :as xbee]
            [xbee.models.core :as models])
  (:import (com.digi.xbee.api.exceptions XBeeException))
  (:gen-class))

(defn -main
  ([]
    (-main "COM1"))
  ([port]
    (-main port "9600"))
  ([port baud-rate]
    (-main port baud-rate "This is a test message."))
  ([port baud-rate msg]
    (logger/set-level! '[xbee xbee-example com.digi] :info)
    (let [device (xbee/create-device port baud-rate)]
      (xbee/open device)
      (xbee/send-broadcast-data device msg)
      (xbee/close device))))
