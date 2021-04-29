# 工程简介

# 延伸阅读

CREATE TABLE `checker_proxy` (
  `id` int(16) NOT NULL,
  `local_id` int(16) DEFAULT NULL,
  `report_id` varchar(64) DEFAULT NULL,
  `addr` varchar(64) DEFAULT NULL,
  `type` int(4) DEFAULT NULL,
  `kind` int(4) DEFAULT NULL,
  `timeout` int(8) DEFAULT NULL,
  `cookie` varchar(8) DEFAULT NULL,
  `referer` varchar(8) DEFAULT NULL,
  `post` varchar(8) DEFAULT NULL,
  `ip` varchar(16) DEFAULT NULL,
  `addr_geo_iso` varchar(32) DEFAULT NULL,
  `addr_geo_country` varchar(32) DEFAULT NULL,
  `addr_geo_city` varchar(32) DEFAULT NULL,
  `ip_geo_iso` varchar(16) DEFAULT NULL,
  `ip_geo_country` varchar(32) DEFAULT NULL,
  `ip_geo_city` varchar(32) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `skip` varchar(32) DEFAULT NULL,
  `from_cache` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `timeout` (`timeout`,`addr_geo_country`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

