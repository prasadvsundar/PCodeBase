package com.cognitive;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * @author Rohan Kamat(EmpId:1015)
 * @version 1.0
 * @organization NanoBi Analytics
 * @Date Aug 22, 2016
 */
public class Taxonomy {

	Set<String> INDENT = new HashSet<String>();
	Set<String> DESC = new HashSet<String>();
	//String apikey = "c01a52c5f439fc76125993a16a7ab1980d51acb5";
	String apikey = "d10047a1c728536931b529ce8b943e7d1f14a7a5";
	// String apikey = "fc900428428a7709119d8f5fa3ea40a5049070bd";
	{
		INDENT.add("");
		DESC.add("");
	}

	String chapter84 = "[/business and industrial/energy/nuclear power, /business and industrial/energy/electricity, /technology and computing]=8401.10.00.00,[/automotive and vehicles/auto parts, /science/chemistry, /law, govt and politics/law enforcement/fire department]=8401.20.00.00,[/automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/printers, /automotive and vehicles/cars]=8401.30.00.00,[/automotive and vehicles/auto parts, /business and industrial/energy/nuclear power, /technology and computing]=8401.40.00.00,[/home and garden/appliances/stoves, /home and garden/appliances, /business and industrial/energy/natural gas]=8402.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8402.90.00,[/home and garden/appliances/stoves, /home and garden/appliances, /business and industrial/energy/natural gas]=8403.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8403.90.00.00,[/law, govt and politics/law enforcement/coast guard, /business and industrial/energy/oil, /business and industrial/energy/coal]=8404.10.00,[/business and industrial/energy/electricity, /home and garden/home furnishings/lamps and lighting, /art and entertainment/visual art and design/design]=8404.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8404.90.00.00,[/business and industrial/energy/natural gas, /business and industrial/energy/oil, /health and fitness/disease/allergies]=8405.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8405.90.00.00,[/automotive and vehicles/boats and watercraft, /business and industrial/energy/renewable energy/wind energy, /technology and computing]=8406.10,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8406.90,[/travel/transports/air travel/airplanes, /automotive and vehicles/vehicle brands/rolls-royce, /law, govt and politics/armed forces/air force]=8407.10.00,[/automotive and vehicles/boats and watercraft, /science/engineering, /business and industrial/manufacturing]=8408.10.00,[/automotive and vehicles/electric vehicles, /automotive and vehicles/commercial vehicles, /business and industrial/company/bankruptcy]=8408.20,[/travel/transports/air travel/airplanes, /automotive and vehicles/vehicle brands/rolls-royce, /law, govt and politics/armed forces/air force]=8409.10.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8410.90.00.00,[/food and drink/food allergies, /health and fitness/disease/allergies, /law, govt and politics/government]=8412.10.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8412.90,[/food and drink/beverages/alcoholic beverages/cocktails and beer, /business and industrial/construction, /business and industrial/energy/oil]=8413.20.00.00,[/business and industrial/energy/oil, /business and industrial/energy/renewable energy/fuel cell, /business and industrial/energy/oil/diesel fuel]=8413.30,[/business and industrial/construction, /business and industrial/chemicals industry/dyes and pigments, /home and garden/gardening and landscaping/yard and patio]=8413.40.00.00,[/business and industrial/energy/oil, /business and industrial/manufacturing, /science/medicine/surgery]=8414.10.00.00,[/law, govt and politics/armed forces/air force, /science/ecology/pollution, /business and industrial/logistics/air freight]=8414.20.00.00,[/home and garden/appliances, /home and garden/home improvement and repair/power tools, /technology and computing]=8414.30,[/home and garden/home improvement and repair/power tools, /style and fashion/accessories/backpacks, /automotive and vehicles/road-side assistance]=8414.40.00.00,[/home and garden/appliances/dishwashers, /automotive and vehicles/cars, /home and garden/appliances/refrigerators and freezers]=8414.60.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8414.90,[/real estate/apartments, /home and garden/bed and bath/bathroom, /home and garden/bed and bath/bedroom]=8415.10,[/business and industrial/metals, /automotive and vehicles/motorcycles, /automotive and vehicles/boats and watercraft]=8415.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8415.90,[/home and garden/appliances/stoves, /business and industrial/energy/oil, /business and industrial/energy/oil/diesel fuel]=8416.10.00.00,[/home and garden/appliances, /shopping/toys, /science/engineering]=8416.30.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8416.90.00.00,[/business and industrial/energy/coal, /business and industrial/energy/oil, /business and industrial/manufacturing]=8417.10.00.00,[/food and drink/desserts and baking, /food and drink, /food and drink/food and grocery retailers/bakeries]=8417.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8417.90.00.00,[/home and garden/gardening and landscaping/yard and patio, /home and garden/bed and bath/bathroom, /business and industrial/construction]=8418.10.00,[/home and garden/appliances/refrigerators and freezers, /health and fitness/disease/gerd and acid reflux, /food and drink/beverages/non alcoholic beverages/bottled water]=8418.30.00.00,[/home and garden/appliances/refrigerators and freezers, /art and entertainment/visual art and design/design, /art and entertainment/theatre]=8418.40.00.00,[/science/medicine/medical research, /society/welfare/healthcare/hospital, /pets/aquariums]=8419.20.00,[/technology and computing/software, /food and drink/food/grains and pasta, /business and industrial/energy/oil]=8419.40.00,[/technology and computing, /business and industrial/energy/oil, /art and entertainment/visual art and design/design]=8419.50,[/law, govt and politics/armed forces/air force, /science/ecology/pollution, /business and industrial/logistics/air freight]=8419.60,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8419.90,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8420.10,[/business and industrial/chemicals industry/plastics and polymers, /style and fashion/beauty/face and body care/hygiene and toiletries, /home and garden/laundry]=8422.20.00.00,[/business and industrial/chemicals industry/plastics and polymers, /food and drink/beverages, /food and drink/beverages/alcoholic beverages/wine]=8422.30,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8422.90,[/home and garden/appliances, /family and parenting/children, /business and industrial]=8423.10.00,[/business and industrial/manufacturing, /food and drink/food/baked goods, /business and industrial/metals]=8423.20,[/food and drink, /business and industrial/energy/oil, /home and garden]=8423.30.00.00,[/automotive and vehicles/auto parts, /sports/gymnastics/calisthenics, /sports/weightlifting]=8423.90,[/home and garden/appliances, /automotive and vehicles/boats and watercraft, /finance/personal finance/insurance]=8424.10.00.00,[/home and garden/appliances, /sports/paintball, /shopping/toys]=8424.20,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /shopping/toys, /food and drink/food/grains and pasta]=8424.30,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8424.90,[/business and industrial/construction, /sports/climbing, /technology and computing]=8426.20.00.00,No Lable=8426.30.00.00,[/automotive and vehicles/cars, /automotive and vehicles/electric vehicles, /automotive and vehicles/scooters and mopeds]=8427.10,[/automotive and vehicles/cars, /business and industrial/logistics/air freight, /business and industrial/logistics/freight train]=8428.10.00.00,[/business and industrial/manufacturing, /technology and computing, /art and entertainment/visual art and design/design]=8428.20.00,[/sports/walking, /shopping, /home and garden/gardening and landscaping/landscaping]=8428.40.00.00,[/home and garden/home furnishings/sofas and chairs, /travel/tourist destinations/ski resorts, /home and garden/home furnishings]=8428.60.00.00,[/art and entertainment/visual art and design/design, /shopping/retail/wholesalers, /shopping/toys/dolls]=8429.20.00.00,[/home and garden/home improvement and repair/power tools, /art and entertainment/music/musical instruments, /shopping/retail/outlet stores]=8429.30.00,[/food and drink/beverages/non alcoholic beverages/coffee and tea, /business and industrial/construction, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines]=8429.40.00,[]=8430.10.00.00,[]=8430.20.00,[/business and industrial/logistics/freight train, /automotive and vehicles/trucks and suvs/pickup trucks, /business and industrial/energy/oil/oil and gas prices]=8431.10.00,[/business and industrial/logistics/freight train, /automotive and vehicles/trucks and suvs/pickup trucks, /business and industrial/energy/oil/oil and gas prices]=8431.20.00.00,[/automotive and vehicles/cars, /home and garden/home improvement and repair/power tools, /society/unrest and war]=8432.10.00,[/home and garden, /home and garden/gardening and landscaping/yard and patio, /home and garden/gardening and landscaping/gardening]=8432.30.00,[/business and industrial/agriculture and forestry/crops and seed, /business and industrial/agriculture and forestry/organic farming, /home and garden]=8432.40.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8432.90.00,[/science/ecology/waste management/recycling, /business and industrial/agriculture and forestry/crops and seed, /business and industrial/agriculture and forestry/livestock]=8433.40.00.00,[/food and drink/food/baked goods, /business and industrial/construction, /food and drink/beverages]=8433.60.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8433.90,[/business and industrial/agriculture and forestry/farms and ranches, /health and fitness/disease/aids and hiv, /shopping/retail/wholesalers]=8434.10.00.00,[/business and industrial/agriculture and forestry/farms and ranches, /food and drink/food/grains and pasta, /food and drink/food allergies]=8434.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8434.90.00.00,[]=8435.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8435.90.00.00,[/pets/animal welfare, /food and drink, /technology and computing/software/shareware and freeware]=8436.10.00.00,[/food and drink/food/grains and pasta, /food and drink/food/fruits and vegetables, /business and industrial/energy/oil]=8437.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8437.90.00,[/food and drink/food/grains and pasta, /food and drink/food and grocery retailers/bakeries, /food and drink]=8438.10.00,[/food and drink/desserts and baking, /food and drink/food/candy and sweets, /food and drink/beverages]=8438.20.00.00,[/food and drink/food/candy and sweets, /business and industrial/chemicals industry, /food and drink/desserts and baking]=8438.30.00.00,[/food and drink/beverages/alcoholic beverages/cocktails and beer, /art and entertainment/shows and events/festival, /art and entertainment]=8438.40.00.00,[/food and drink/food and grocery retailers/butchers, /business and industrial/agriculture and forestry/livestock, /food and drink/food/grains and pasta]=8438.50.00,[/food and drink/food/fruits and vegetables, /food and drink/food/grains and pasta, /food and drink]=8438.60.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8438.90,[/business and industrial/energy/renewable energy/biofuel, /business and industrial/agriculture and forestry/crops and seed, /business and industrial/chemicals industry/adhesives]=8439.10.00,[/business and industrial/chemicals industry/plastics and polymers, /science/ecology/waste management/recycling, /art and entertainment/books and literature]=8439.20.00,[/business and industrial/chemicals industry/plastics and polymers, /science/ecology/waste management/recycling, /art and entertainment/books and literature]=8439.30.00.00,[]=8440.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8440.90.00.00,[/home and garden/home improvement and repair/power tools, /shopping/retail/outlet stores, /shopping/toys/dolls]=8441.10.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8441.20.00.00,[/business and industrial/chemicals industry/plastics and polymers, /art and entertainment/music/musical instruments/drums, /shopping/toys]=8441.30.00.00,[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/manufacturing, /art and entertainment/visual art and design/design]=8441.40.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8441.90.00.00,[/sports/gymnastics, /law, govt and politics/law enforcement/fire department, /home and garden/appliances]=8442.30.01,[/automotive and vehicles/auto parts, /home and garden/appliances, /sports/gymnastics]=8442.40.00.00,[/art and entertainment/visual art and design/design, /technology and computing/hardware/computer peripherals/printers, copiers and fax/printers, /technology and computing/hardware]=8442.50,[/technology and computing/software/graphics software/animation, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /art and entertainment/visual art and design/design]=8444.00.00.10,[/business and industrial/textile industry, /hobbies and interests/arts and crafts/knitting, /business and industrial]=8445.20.00.00,[/business and industrial, /business and industrial/textile industry, /finance/investing/stocks]=8445.30.00,[/hobbies and interests/arts and crafts/knitting, /art and entertainment/visual art and design/design, /business and industrial/textile industry]=8445.40.00.00,[/business and industrial/textile industry, /business and industrial/energy/natural gas, /business and industrial/manufacturing]=8446.10.00,[/health and fitness/disease/diabetes, /art and entertainment/visual art and design/design, /business and industrial/energy/natural gas]=8446.30,[/hobbies and interests/arts and crafts/knitting, /hobbies and interests/needlework, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines]=8447.20,[/law, govt and politics/law enforcement/coast guard, /automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines]=8448.20,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8449.00.10.00,[/home and garden/bed and bath/bedroom/bedding and bed linens, /business and industrial/manufacturing, /business and industrial/construction]=8450.20.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8450.90,[/home and garden/laundry, /business and industrial, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines]=8451.10.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/copiers, /business and industrial, /technology and computing]=8451.30.00.00,[/business and industrial/chemicals industry/dyes and pigments, /technology and computing, /home and garden/appliances/dishwashers]=8451.40.00.00,[/business and industrial/textile industry, /home and garden/home furnishings/sofas and chairs, /art and entertainment/visual art and design/design]=8451.50.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8451.90,[/home and garden/appliances, /hobbies and interests/needlework, /business and industrial]=8452.10.00,[/hobbies and interests/needlework, /hobbies and interests/arts and crafts/knitting, /hobbies and interests/arts and crafts/crochet]=8452.30.00.00,[/automotive and vehicles/auto parts, /hobbies and interests/needlework, /home and garden/home furnishings]=8452.90,[/hobbies and interests/magic and illusion, /business and industrial/tanning, /home and garden/home furnishings/rugs and carpets]=8453.10.00.00,[/style and fashion/footwear, /business and industrial/shipbuilding, /style and fashion/footwear/shoes]=8453.20.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8453.90,[/technology and computing/software/shareware and freeware, /technology and computing/electronic components, /technology and computing]=8454.10.00.00,[/business and industrial/manufacturing, /food and drink/food/grains and pasta, /art and entertainment/visual art and design/design]=8454.20.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8454.30.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8454.90.00,[/business and industrial/paper industry, /education/graduate school/college, /business and industrial/textile industry]=8455.10.00.00,[/business and industrial/paper industry, /technology and computing, /education/graduate school/college]=8455.30.00,[/science/physics/optics, /health and fitness/therapy, /home and garden/home furnishings/lamps and lighting]=8456.10,[/travel/transports/air travel/airlines, /technology and computing/hardware/computer components/chips and processors, /business and industrial/business operations/management/business process]=8456.20,[/travel/transports/air travel/airlines, /technology and computing/hardware/computer components/chips and processors, /business and industrial/business operations/management/business process]=8456.30,[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/manufacturing, /family and parenting/children/daycare and preschool]=8457.10.00,[/business and industrial/construction, /business and industrial/manufacturing, /science/engineering]=8457.20.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8457.30.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8459.10.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8460.40,[/technology and computing/software, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework]=8461.20,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8461.30,[/business and industrial/manufacturing, /technology and computing, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines]=8461.40,[/home and garden/home improvement and repair/power tools, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /business and industrial/construction]=8461.50,[/business and industrial/metals, /business and industrial, /home and garden/home improvement and repair/power tools]=8462.10.00,[/hobbies and interests/arts and crafts/jewelry making, /business and industrial/metals, /business and industrial]=8463.10.00,[/hobbies and interests/needlework, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /art and entertainment/visual art and design/art and craft supplies]=8463.20.00,[/business and industrial/metals, /hobbies and interests/arts and crafts/jewelry making, /business and industrial]=8463.30.00,No Lable=8464.10.01.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8464.20.01,[/business and industrial, /business and industrial/business operations, /business and industrial/manufacturing]=8465.10.00,[]=8466.10.01,[]=8466.20,[/family and parenting/children, /business and industrial/metals, /technology and computing/internet technology/email]=8466.30,[/home and garden/home furnishings/lamps and lighting, /technology and computing/consumer electronics/radios, /technology and computing/hardware/computer peripherals/printers, copiers and fax/scanners]=8468.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8468.90,[/technology and computing, /technology and computing/consumer electronics/camera and photo equipment/cameras and camcorders/cameras, /technology and computing/hardware/computer]=8470.10.00,No Lable=8470.50.00,[/technology and computing/hardware/computer, /technology and computing/hardware, /technology and computing]=8471.30.01.00,[/home and garden, /technology and computing/mp3 and midi, /technology and computing/hardware/computer components/chips and processors]=8471.50.01,[/home and garden, /technology and computing/mp3 and midi, /technology and computing/hardware/computer components/sound cards]=8471.60,[/automotive and vehicles/vehicle rental, /technology and computing/computer certification, /technology and computing/data centers]=8471.70,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8472.10.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /art and entertainment/visual art and design/design, /hobbies and interests/collecting/stamps and coins]=8472.30.00.00,[/automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /automotive and vehicles/vehicle brands/jeep]=8473.10,[/automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /automotive and vehicles/vehicle brands/jeep]=8473.30,[/automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /automotive and vehicles/vehicle brands/jeep]=8473.40,[/automotive and vehicles/auto parts, /technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /business and industrial/construction]=8473.50,[/home and garden/appliances/dishwashers, /home and garden/appliances, /home and garden/appliances/refrigerators and freezers]=8474.10.00,[/business and industrial/manufacturing, /food and drink/beverages/non alcoholic beverages/coffee and tea, /technology and computing]=8474.20.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8474.90.00,[/home and garden/home furnishings/lamps and lighting, /home and garden/appliances, /technology and computing]=8475.10.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8475.90,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8476.90.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8477.10,[/business and industrial/chemicals industry/plastics and polymers, /technology and computing/hardware/computer components/chips and processors, /business and industrial/manufacturing]=8477.20.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8477.30.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /business and industrial/chemicals industry/plastics and polymers, /technology and computing]=8477.40.01.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8477.90,[]=8478.10.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8478.90.00,[/law, govt and politics/legal issues/legislation/building laws, /business and industrial/construction, /business and industrial]=8479.10.00,[/business and industrial/energy/oil, /food and drink, /health and fitness/disease/cholesterol]=8479.20.00.00,[/business and industrial/chemicals industry/plastics and polymers, /technology and computing, /business and industrial/construction]=8479.30.00.00,[/technology and computing/hardware/computer peripherals/printers, copiers and fax/fax machines, /hobbies and interests/needlework, /home and garden/appliances]=8479.40.00.00,[/business and industrial/automation/robotics, /technology and computing, /business and industrial/manufacturing]=8479.50.00.00,[/business and industrial/energy/electricity, /law, govt and politics/armed forces/air force, /home and garden/appliances/refrigerators and freezers]=8479.60.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8479.90,[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/metals, /art and entertainment/visual art and design/design]=8480.10.00.00,[/health and fitness/disease/allergies, /hobbies and interests/arts and crafts/candle and soap making, /home and garden/home furnishings/rugs and carpets]=8480.20.00.00,[/business and industrial/chemicals industry/plastics and polymers, /hobbies and interests/arts and crafts/crochet, /technology and computing]=8480.30.00.00,[/hobbies and interests/arts and crafts/candle and soap making, /business and industrial/chemicals industry/plastics and polymers, /business and industrial/metals]=8480.50.00,[/business and industrial/chemicals industry/plastics and polymers, /hobbies and interests/arts and crafts/candle and soap making, /science/geology/mineralogy]=8480.60.00,[]=8481.10.00,[/science/physics/hydraulics, /home and garden/home improvement and repair/power tools, /technology and computing]=8481.20.00,[]=8481.30,[/society/welfare/social services, /home and garden/environmental safety, /health and fitness]=8481.40.00.00,[/automotive and vehicles/auto parts, /automotive and vehicles/cars, /automotive and vehicles/motorcycles]=8481.90,[/sports/skateboarding, /business and industrial/construction, /business and industrial/metals]=8482.10,[/sports/skating, /sports/skateboarding, /art and entertainment/visual art and design/design]=8482.20.00,[/science/mathematics/geometry, /sports/skateboarding, /art and entertainment/visual art and design/design]=8482.30.00,[/sports/skateboarding, /hobbies and interests/arts and crafts/knitting, /hobbies and interests/needlework]=8482.40.00.00,[/automotive and vehicles/auto parts, /business and industrial/energy/oil, /automotive and vehicles/cars]=8483.10,[/sports/skateboarding, /automotive and vehicles/auto parts, /business and industrial/construction]=8483.20,[/sports/skateboarding, /technology and computing/consumer electronics/camera and photo equipment/cameras and camcorders/cameras, /home and garden]=8483.30,[/art and entertainment/visual art and design/design, /automotive and vehicles/motorcycles, /automotive and vehicles/cars]=8483.40,[/automotive and vehicles/vehicle brands/honda, /automotive and vehicles/cars, /business and industrial/energy/oil]=8483.50,[/business and industrial/metals, /automotive and vehicles/auto parts, /automotive and vehicles]=8483.60,[/automotive and vehicles/motorcycles, /automotive and vehicles/auto parts, /pets/large animals]=8483.90,[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/chemicals industry/adhesives, /business and industrial/construction]=8484.10.00.00,[/business and industrial/energy/oil, /business and industrial/manufacturing, /science/engineering]=8484.20.00.00,[/business and industrial/manufacturing, /business and industrial/chemicals industry/adhesives, /food and drink/food/candy and sweets]=8486.10.00.00,[/technology and computing/electronic components, /technology and computing, /art and entertainment/visual art and design/design]=8486.20.00.00,[/technology and computing, /technology and computing/consumer electronics/tv and video equipment/televisions, /home and garden/appliances]=8486.30.00.00,[/business and industrial/company/bankruptcy, /law, govt and politics/law enforcement/fire department, /home and garden/appliances]=8486.40.00,[/automotive and vehicles/auto parts, /automotive and vehicles/vehicle brands/jeep, /automotive and vehicles/motorcycles]=8486.90.00.00,[/automotive and vehicles/boats and watercraft, /travel/transports/air travel/airplanes, /travel/transports/air travel/helicopters]=8487.10.00";
	
	public String getTaxonomy(String text) {
		AlchemyLanguage api = new AlchemyLanguage();
		api.setApiKey(apikey);
		api.setEndPoint("https://access.alchemyapi.com/calls");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, text);
		ServiceCall<Taxonomies> taxonomies = api.getTaxonomy(params);
		return taxonomies.execute().getTaxonomy().toString();
	}

	public List getTaxonomylist(String text) {
		List alllable = new ArrayList<String>();
		AlchemyLanguage api = new AlchemyLanguage();
		api.setApiKey(apikey);
		api.setEndPoint("https://access.alchemyapi.com/calls");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, text);
		ServiceCall<Taxonomies> taxonomies = api.getTaxonomy(params);
		List<com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy> taxonomy = taxonomies
				.execute().getTaxonomy();

		for (int i = 0; i < taxonomy.size(); i++) {
			com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy taxnome = (com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy) taxonomy
					.get(i);
			alllable.add(taxnome.getLabel());
		}
	
		return (List) alllable;
	}

	public List getConcepts(String text) {
		List alllable = new ArrayList<String>();
		AlchemyLanguage api = new AlchemyLanguage();
		api.setApiKey(apikey);
		api.setEndPoint("https://access.alchemyapi.com/calls");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, text);
		ServiceCall<Concepts> concepts = api.getConcepts(params);
		List<com.ibm.watson.developer_cloud.alchemy.v1.model.Concept> conceptlist = concepts
				.execute().getConcepts();

		for (int i = 0; i < conceptlist.size(); i++) {
			com.ibm.watson.developer_cloud.alchemy.v1.model.Concept concept = (com.ibm.watson.developer_cloud.alchemy.v1.model.Concept) conceptlist
					.get(i);
			alllable.add(concept.getText());
		}
		return alllable;
	}

	public String getSentiment(String text) {
		AlchemyLanguage api = new AlchemyLanguage();
		api.setApiKey(apikey);
		api.setEndPoint("https://access.alchemyapi.com/calls");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, "text");
		ServiceCall<DocumentSentiment> sentiment = api.getSentiment(params);
		return sentiment.execute().getSentiment().toString();
	}

	public List getKeywords(String text) {
		List alllable = new ArrayList<String>();
		AlchemyLanguage api = new AlchemyLanguage();
		api.setApiKey(apikey);
		api.setEndPoint("https://access.alchemyapi.com/calls");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, text);
		ServiceCall<Keywords> Keywords = api.getKeywords(params);
		List<com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword> conceptlist = Keywords
				.execute().getKeywords();
		for (int i = 0; i < conceptlist.size(); i++) {
			com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword concept = (com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword) conceptlist
					.get(i);
			String keyword = concept.getText();
			alllable.add(keyword.trim());
		}
		return alllable;
	}

	public String getChapterno(String t) {
		Map<String, String> alllable = new HashMap<String, String>();
		alllable.put("Other base metals; cermets; articles thereof", "81");
		alllable.put(
				"Tools, implements, cutlery, spoons and forks, of base metal; parts thereof of base metal",
				"82");
		alllable.put("Miscellaneous articles of base metal", "83");
		alllable.put(
				"Nuclear reactors, boilers, machinery and mechanical appliances; parts thereof",
				"84");
		alllable.put(
				"Electrical machinery and equipment and parts thereof; sound recorders and reproducers, television image and sound recorders and reproducers, and parts and accessories of such articles",
				"85");
		;
		alllable.put(
				"Railway or tramway locomotives, rolling-stock and parts thereof; railway or tramway track fixtures and fittings and parts thereof; mechanical (including electro-mechanical) traffic signalling equipment of all kinds",
				"86");
		;
		alllable.put(
				"Vehicles other than railway or tramway rolling stock, and parts and accessories thereof",
				"87");
		alllable.put("Aircraft, spacecraft, and parts thereof", "88");
		alllable.put("Ships, boats and floating structures", "89");
		String result = alllable.get(t);
		return result;
	}

	public List<String> getChapterTaxonomay() {
		String taxonamystring = "/business and industrial/shipbuilding,/automotive and vehicles/commercial vehicles,/business and industrial/metals,/automotive and vehicles/cars,/business and industrial/aerospace and defense/space technology,/travel/transports/public transport,/business and industrial/chemicals industry/plastics and polymers,/home and garden/appliances,/technology and computing/consumer electronics/audio equipment,/automotive and vehicles/boats and watercraft,/technology and computing,/style and fashion/jewelry,/automotive and vehicles/auto parts,/technology and computing/consumer electronics/tv and video equipment/dvrs and set-top boxes,/finance/investing/stocks,/business and industrial/construction";
		taxonamystring = taxonamystring.trim();
		System.out.println(taxonamystring);
		return Arrays.asList(taxonamystring.split(","));
		/*
		 * List alllable=new ArrayList<String>();
		 * alllable.add("Other base metals; cermets; articles thereof");
		 * alllable.add(
		 * "Tools, implements, cutlery, spoons and forks, of base metal; parts thereof of base metal"
		 * ); alllable.add("Miscellaneous articles of base metal");
		 * alllable.add(
		 * "Nuclear reactors, boilers, machinery and mechanical appliances; parts thereof"
		 * ); alllable.add(
		 * "Electrical machinery and equipment and parts thereof; sound recorders and reproducers, television image and sound recorders and reproducers, and parts and accessories of such articles"
		 * ); alllable.add(
		 * "Railway or tramway locomotives, rolling-stock and parts thereof; railway or tramway track fixtures and fittings and parts thereof; mechanical (including electro-mechanical) traffic signalling equipment of all kinds"
		 * ); alllable.add(
		 * "Vehicles other than railway or tramway rolling stock, and parts and accessories thereof"
		 * ); alllable.add("Aircraft, spacecraft, and parts thereof");
		 * alllable.add("Ships, boats and floating structures");
		 * 
		 * Map<Object,Object> labels=new HashMap<Object,Object>(); for(int
		 * i=0;i<alllable.size();i++){ List<String>
		 * list=getTaxonomylist(alllable.get(i).toString());
		 * System.out.println(getChapterno(alllable.get(i).toString()));
		 * labels.put(alllable.get(i).toString(),list); }
		 * 
		 * // map to string Map<String, Integer> myMap = new HashMap<String,
		 * Integer>(); String s =
		 * "SALES:0,SALE_PRODUCTS:1,EXPENSES:2,EXPENSES_ITEMS:3"; String[] pairs
		 * = s.split(","); for (int i=0;i<pairs.length;i++) { String pair =
		 * pairs[i]; String[] keyValue = pair.split(":"); myMap.put(keyValue[0],
		 * Integer.valueOf(keyValue[1])); }
		 * 
		 * //labels //Set<T> mySet = new HashSet<T>(Arrays.asList(words));
		 * //Set<String> taxonamy = new HashSet<String>(labels);
		 * System.out.println(labels); //return labels;
		 */}

	public List<String> getChapter(String key) {
		Map<Object, Object> chapter = new HashMap<Object, Object>();
		String s = "[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/metals, /style and fashion/jewelry]=81, [/style and fashion/jewelry, /business and industrial/metals, /finance/investing/stocks]=83, [/business and industrial/aerospace and defense/space technology, /automotive and vehicles/auto parts, /technology and computing]=88, [/home and garden/appliances, /technology and computing/consumer electronics/audio equipment, /technology and computing/consumer electronics/tv and video equipment/dvrs and set-top boxes]=85, [/automotive and vehicles/cars, /automotive and vehicles/auto parts, /travel/transports/public transport]=87, [/business and industrial/metals, /style and fashion/jewelry, /automotive and vehicles/auto parts]=82, [/automotive and vehicles/cars, /automotive and vehicles/auto parts, /business and industrial/construction]=86, [/automotive and vehicles/boats and watercraft, /business and industrial/shipbuilding, /automotive and vehicles/commercial vehicles]=89, [/home and garden/appliances, /technology and computing, /automotive and vehicles/auto parts]=84";
		String[] pairs = s.split(", \\[");
		for (int i = 0; i < pairs.length; i++) {
			String pair = pairs[i];
			String[] keyValue = pair.split("=");
			chapter.put(keyValue[0], keyValue[1]);
		}

		List<String> chapterNo = new ArrayList<String>();
		Iterator keyIterator = chapter.keySet().iterator();
		while (keyIterator.hasNext()) {
			String keyname = (String) keyIterator.next();
			if (keyname.contains(key)) {
				chapterNo.add(chapter.get(keyname).toString());
			}

		}
		return chapterNo;
	}

	/**Old method
	 * 
	 *   */
	public void readCSV() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(
				"/home/nanobi/Downloads/htsdata.csv"));
		String[] nextLine;
		StringBuilder htsTaxonamyString = new StringBuilder();
		while ((nextLine = reader.readNext()) != null) {
			//if (INDENT.contains(nextLine[1])
					//&& !satartWithThisString(DESC, nextLine[2]) && !nextLine[0].equalsIgnoreCase("")) {
				if (INDENT.contains(nextLine[1])
						&& !satartWithThisString(DESC, nextLine[2]) && !nextLine[0].equalsIgnoreCase("")) {
				System.out.println(nextLine[0] + "   " + nextLine[1] + "   "
						+ nextLine[2]);
				StringBuilder htsTaxNoString = new StringBuilder();
				String taxonomyString = "";
				try{
					taxonomyString = getTaxonomylist(nextLine[2]).toString();
				}catch(Exception e){
					System.out.println("Exception "+e.getMessage());
					taxonomyString="No Lable";
				}
				htsTaxNoString.append(taxonomyString).append("=").append(nextLine[0]);
				htsTaxonamyString.append(",").append(htsTaxNoString.toString());
			}
		}
		System.out.println(htsTaxonamyString.toString());
	}
	
	/**Old method
	 * 
	 *   */
	public void convertHTSCodeToLable() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(
				"/home/nanobi/HTS Files/htsdata.csv"));
		FileWriter writer = new FileWriter(
				"/home/nanobi/HTS Files/out/htsdata.csv");
		String[] nextLine;
		String[] writeLine;
		StringBuilder htsDescString = new StringBuilder();
		
		int i=0;
		while ((nextLine = reader.readNext()) != null) {
			StringBuilder htsTaxonamyString = new StringBuilder();
			StringBuilder dataString = new StringBuilder();
			//writeLine = new String[nextLine.length+2];
			if(i>0){	
				String htsNo = nextLine[0];
				String htsDesc = nextLine[2];
				String htsNoWithoutDot = htsNo.replace(".", "");
				int digitLength = htsNoWithoutDot.length();
				//StringBuilder taxonamyString=new StringBuilder();
				if(digitLength==10&&digitLength!=4){
					htsTaxonamyString.append(htsDescString).append(" ").append(htsDesc);
				}else if(digitLength!=4){
					htsDescString.append(" ").append(htsDesc);
					htsTaxonamyString=htsDescString;
				}else{
					htsDescString = new StringBuilder();
					htsDescString.append(" ").append(htsDesc);
					htsTaxonamyString=htsDescString;
				}
				System.out.println(htsNo+" : "+htsTaxonamyString);
				
				if(digitLength!=0){
					String taxonomyString = "";
					try{
						taxonomyString = getTaxonomylist(htsTaxonamyString.toString()).toString();
					}catch(Exception e){
						System.out.println("Exception "+e.getMessage());
						taxonomyString="No Lable";
					}
					
					for(String line:nextLine){
						dataString.append("\"").append(line).append("\"").append(",");
					}
					dataString.append("\"").append(htsTaxonamyString.toString()).append("\"").append(",").append("\"").append(taxonomyString).append("\"").append(",").append("\"").append(nextLine[0]).append("\"");
					
					dataString.append("\n");
				
					writer.write(dataString.toString());
				}		
			}
			//writeLine=nextLine;
			if(i==0){
				for(String line:nextLine){
					dataString.append("\"").append(line).append("\"").append(",");
				}
				dataString.append("\"").append("taxonomy_desc").append("\"").append(",");
				dataString.append("\"").append("taxonomy_lable").append("\"").append(",");
				dataString.append("\"").append("hts_no").append("\"");
				dataString.append("\n");
				writer.write(dataString.toString());
			}
			
			i++;
			
			//htsTaxonamyString.append(",").append(htsTaxNoString.toString());
			
		    
		}
		 writer.flush();
		 writer.close();
	}

	public boolean satartWithThisString(Set<String> stringSet, String desc) {
		for (String str : stringSet) {
			return desc.startsWith(str);
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Taxonomy taxonomy = new Taxonomy();
		taxonomy.convertHTSCodeToLable();
		//System.out.println(taxonomy.getTaxonomylist("Ships' or boats' propellers and blades therefor"));
		// List s = taxonomy.getChapterTaxonomay();
		// System.out.println(s.contains("/finance/investing/stocks"));
		// System.out.println(taxonomy.getTaxonomylist("automotive and
		// vehicles"));
		// System.out.println(taxonomy.getChapter(
		// "[/business and industrial/chemicals industry/plastics and polymers, /business and industrial/metals, /style and fashion/jewelry]"));
		// System.out.println(taxonomy.getKeywords("Labyrinth glands and
		// manometer for used in turbines"));

	}
}