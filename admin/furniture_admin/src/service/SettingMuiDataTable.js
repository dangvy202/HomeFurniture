import MUIDataTable from "mui-datatables";


export const TableShowData = ({columns,listSet}) => {
    const options = {
        filter: true,
        selectableRows: 'none',
        filterType: 'dropdown',
        responsive: 'vertical',
      };
   
      return (
        <MUIDataTable
          title={"Order List"}
          data={listSet}
          columns={columns}
          options={options}
        />
      );
}